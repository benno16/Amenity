package properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;

import dao.DaoFactory;
import dao.GenericDao;

public class ElementProperties implements IPropertySource {

	final protected EObject element; 
	
	private IPropertyDescriptor[] propertyDescriptors;
	private String[] literals;
	
	public ElementProperties ( EObject element) {
		super();
		this.element = element;
		initProperties();
	}
	
	private void initProperties() {	}

	@Override
	public Object getEditableValue() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 * Descriptors for property view are created here
	 * differentiation between:
	 * - String
	 * - Date
	 * - Boolean
	 * - ENUM
	 */
	
	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		java.util.List<IPropertyDescriptor> descriptors = new java.util.ArrayList<IPropertyDescriptor>();
		
		for ( EAttribute attribute : element.eClass().getEAllAttributes() ) {
			
			if ( attribute.getEType().getName().equals("EString") || 
					attribute.getEType().getName().equals("Date") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public Image getImage(Object element) {
							return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
						}
					});
					descriptors.add( (IPropertyDescriptor)desc );
					
				} else {
					PropertyDescriptor desc = new TextPropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public Image getImage(Object element) {
							return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_DEF_VIEW);
						}
					});
					descriptors.add( (IPropertyDescriptor)desc );
				}
				
			} else if ( attribute.getEType() instanceof EEnum ) {
				// ENUM has to be changed to integer value
				EEnum eenum = (EEnum) attribute.getEType();
				literals = new String[eenum.getELiterals().size()];
				
				int k = 0;
				for ( EEnumLiteral literal : eenum.getELiterals() ) 
					literals[k++] = literal.getLiteral();
				
				PropertyDescriptor desc = new ComboBoxPropertyDescriptor ( attribute, 
						attribute.getName(), literals);
				
				desc.setLabelProvider(new LabelProvider() {
					
					public String getText(Object element) {
						return literals[(Integer)element];
					}
					
					public Image getImage(Object element) {
						return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
								.getImage(ISharedImages.IMG_OBJ_ELEMENT);
					}
					
				});
				
				descriptors.add( (IPropertyDescriptor)desc );
				
			} else if ( attribute.getEType().getName().equals("EBoolean") ) {

				if ( attribute.isUnsettable() || attribute.isID() ) {
					PropertyDescriptor desc = new PropertyDescriptor ( 
							attribute, attribute.getName() );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : element.toString()
									.equals("1") ? "false" : "true";//$NON-NLS-1$
						}
						public Image getImage(Object element) {
							return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJS_INFO_TSK);
						}
					});
					descriptors.add(desc);
				} else {
					PropertyDescriptor desc = new ComboBoxPropertyDescriptor ( 
							attribute, attribute.getName(),  new String[] { "true", "false" } );
					desc.setLabelProvider(new LabelProvider() {
						public String getText(Object element) {
							return element == null ? "" : element.toString()
									.equals("1") ? "false" : "true";//$NON-NLS-1$
						}
						public Image getImage(Object element) {
							return org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages()
									.getImage(ISharedImages.IMG_OBJ_ELEMENT);
						}
					});
					descriptors.add(desc);
				}
					
			}

		}
		
		propertyDescriptors = new IPropertyDescriptor[ descriptors.size() ];
		
		for ( int i = 0 ; i < descriptors.size(); i++ ) {
			propertyDescriptors[i] = descriptors.get(i);
		}
		
		return  propertyDescriptors;
	}

	@Override
	public Object getPropertyValue(Object id) {
	
		for ( EAttribute a : element.eClass().getEAllAttributes() ) {
			if ( a.getEType() instanceof EEnum) {
				if ( a.equals(id) ) {
					for ( int i = 0; i < literals.length ; i++ ) {
						if ( element.eGet(a).toString().equals(literals[i])) {
							return new Integer(i);
						}
					}
				}
			} else if ( a.getEType().getName().equals("EBoolean") ) {

				return (element.eGet(a).toString().equals("true")) ? new Integer(0) : new Integer(1);
				
			} else if ( a.equals(id)) {
				
				return element.eGet(a);
				
			}
		}
		System.out.println("I should never get here");
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {}

	@Override
	public void setPropertyValue(Object id, Object value) {
		
		for ( EAttribute a : element.eClass().getEAllAttributes() ) {
			if ( a.getEType().getName().equals("EBoolean") ) {
				element.eSet(a, (Integer)value == 0 ? true : false );
			} else 
			if ( a.getEType() instanceof EEnum) {
				if ( a.equals(id) ) {
					for ( int i = 0; i < literals.length ; i++ ) {
						if ( value.toString().equals(literals[i])) {
							System.err.println("I found a matching result");
							element.eSet(a, i);
						}
					}
				}
			} else  
			if ( a.equals(id)) {
				element.eSet(a, value);
			}
		}
		GenericDao sDao = DaoFactory.eINSTANCE.createGenericDao();
		sDao.update(element);
	}

}
