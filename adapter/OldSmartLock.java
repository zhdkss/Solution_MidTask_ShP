package adapter;

public class OldSmartLock implements LegacySystem {
    private boolean locked = true;
    @Override
    public void lock(){
        locked = true;
        System.out.println("old Lock: Locked");
    }
    @Override
    public void unlock(){
        locked = false;
        System.out.println("old Lock: Unlocked");

    }
    @Override
    public boolean isLocked(){
        return locked;

    }
}
