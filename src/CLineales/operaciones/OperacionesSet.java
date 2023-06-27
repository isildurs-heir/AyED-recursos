package CLineales.operaciones;

import CLineales.Listas.ListaSimple.SetAbs;

public interface OperacionesSet {
    public boolean isEmpty();

    public void clean();

    public int getCardinal();

    public boolean contains(Object element);

    public void add(Object element);

    public void remove(Object element);

    public void union(SetAbs set1,SetAbs set2);

    public void intersection(SetAbs set1, SetAbs set2);

    public void diff(SetAbs set1, SetAbs set2);
}
