package baitaptonghop.business.design;

public interface IGeneric <T,E>{
void displayAll();
void addNewElement();
void updateElement();
void deleteElement();
T findById(E id);

}
