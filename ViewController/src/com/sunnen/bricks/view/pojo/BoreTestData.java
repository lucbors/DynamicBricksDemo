package com.sunnen.bricks.view.pojo;

import java.math.BigDecimal;

public class BoreTestData {

    private BigDecimal leftData;
    private BigDecimal rightData;

    public BoreTestData() {
        super();
    }


    public BoreTestData(BigDecimal leftData, BigDecimal rightData) {
           this.leftData = leftData;
           this.rightData = rightData;
       }


    public void setLeftData(BigDecimal leftData) {
        this.leftData = leftData;
    }

    public BigDecimal getLeftData() {
        return leftData;
    }

    public void setRightData(BigDecimal rightData) {
        this.rightData = rightData;
    }

    public BigDecimal getRightData() {
        return rightData;
    }


}
