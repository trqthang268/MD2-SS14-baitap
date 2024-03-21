package baitapmain.baitaptonghop.business.design;

public interface IGenericDesign<T,E> {
    T findById(E id);
    void addNewElement();
    void editElement();
    void deleteElement();
    void displayElement();
    T inputData(boolean isAdd);
}
