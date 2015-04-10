package com.sim.star.bitworxx.starcity.cycle;

import com.sim.star.bitworxx.starcity.game.enums.TimeEnum;

/**
 * Created by WEIS on 09.04.2015.
 */
public class GM_TimeFrame {

    public int D;
    public int M;
    public int Y;

    public int I_D;
    public int I_M;
    public int I_Y;

    public int DH;
    public int MD;
    public int YM;

    public int I_DH;
    public int I_MD;
    public int I_YM;

    public GM_TimeFrame() {
        init_std();
    }

    public GM_TimeFrame(int d, int m, int y, int dh, int ym) {
        I_D = D = d;
        I_M = M = m;
        I_Y = Y = y;
        I_DH = DH = dh;
        I_MD = MD = dh;
        I_YM = YM = ym;
    }

    public void init_std() {
        I_D = D = 1;
        I_M = M = 1;
        I_Y = Y = 3501;
        I_DH = DH = 20;
        I_MD = MD = 20;
        I_YM = YM = 10;
    }

    public TimeEnum interate() {
        TimeEnum result = TimeEnum.NEXT_INTERATE;

        DH--;
        if (DH <= 0) {
            DH = I_DH;
            D++;
            result = TimeEnum.NEXT_DAY;
            MD--;
            if (MD <= 0) {
                D = I_D;
                M++;
                MD = I_MD;
                result = TimeEnum.NEXT_DAY_MONTH;
                YM--;
                if (YM <= 0) {
                    Y++;
                    M = I_M;
                    YM = I_YM;
                    result = TimeEnum.NEXT_DAY_MONTH_YEAR;

                }
            }
        }

        return result;
    }
}
