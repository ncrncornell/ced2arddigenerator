package edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.category;

import edu.cornell.ncrn.ced2ar.ddigen.ddi32.element.ElementWithUrn;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class CategorySchemeElement extends ElementWithUrn {

	public static final String NODE_NAME_CATEGORY_SCHEME = "ddi:CategoryScheme";

	private List<CategoryElement> categoryElementList = new ArrayList<>();

	public CategorySchemeElement(String id, String agency) {
		super(id, agency);
	}

	public void addCategoryElement(CategoryElement categoryElement) {
		synchronized (categoryElementList) {
			categoryElementList.add(categoryElement);
		}
	}

	@Override
	public void appendToElement(Element element, Document doc) {
		Element categoryScheme = doc.createElement(NODE_NAME_CATEGORY_SCHEME);

		for (CategoryElement category : getCategoryElementList()) {
			category.appendToElement(categoryScheme, doc);
		}

		element.appendChild(categoryScheme);
	}

	public List<CategoryElement> getCategoryElementList() {
		return categoryElementList;
	}
}
