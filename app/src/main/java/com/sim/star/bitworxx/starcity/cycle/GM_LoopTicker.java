package com.sim.star.bitworxx.starcity.cycle;

public class GM_LoopTicker {
    public int L1;
    public int L2;
    public int L3;

    public int I_L1;
    public int I_L2;
    public int I_L3;

    public GM_LoopTicker() {
        init_std();
    }

    public GM_LoopTicker(int l1, int l3) {
        I_L1 = I_L2 = L1 = L2 = l1;
        I_L3 = L3 = l3;
    }

    private void init_std() {
        I_L1 = I_L2 = L1 = L2 = 5;
        I_L3 = L3 = 9;
    }

    public LoopEnum iterate() {
        LoopEnum result = LoopEnum.NEXT_ITERATE;

        L3--;
        if (L3 <= 0) {
            L3 = I_L3;
            L2--;
            if (L2 <= 0) {
                L2 = I_L2;
                L1--;
                if (L1 <= 0) {
                    L1 = I_L1;
                    result = LoopEnum.NEXT_LOOP;
                }
            }
        }

        return result;
    }
}
