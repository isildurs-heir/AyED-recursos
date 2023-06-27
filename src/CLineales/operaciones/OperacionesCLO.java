package CLineales.operaciones;

public interface OperacionesCLO{
    public void add(Object element);
    public boolean minor(Object element1,Object element2);
    public boolean major(Object element1,Object element2);
    public int search(Object element);
    public void replace(int index,Object element);
}
