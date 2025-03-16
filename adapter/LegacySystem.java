package adapter;

public interface LegacySystem {
    void lock();
    void unlock();
    boolean isLocked();

}
