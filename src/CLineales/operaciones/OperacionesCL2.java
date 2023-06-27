package CLineales.operaciones;

public interface OperacionesCL2 {
    public Object get(int index);
    public void delete(int index);
    public void clean();
    public boolean isEmpty();
    public int size();
    public void insert(int index,Object element);
    public boolean equals(Object element1, Object element2);
}
