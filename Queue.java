/*
 * A class for a standard first in, first out queue.
 */
interface Queue<N>{    

    public void add(N n);
    
    public void remove();

    public String toString();

    public boolean isEmpty();
}
