package com.sunnen.bricks.view.beans;

import com.sunnen.bricks.view.pojo.BoreTestData;

import java.math.BigDecimal;

import java.math.MathContext;

import java.math.RoundingMode;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeListener;

public class BricksBean {


    public List<BoreTestData> listWithData = new ArrayList();
    private BigDecimal nrOfBricksToBeTested;

    private BigDecimal nrOfRowsToShow;
    private BigDecimal nrOfColumnsPerRow= new BigDecimal(3);

    private Boolean showCol1=false;
    private Boolean showCol2=false;
    private Boolean showCol3=false;
    private Boolean showCol4=false;
    
    private BigDecimal one = new BigDecimal(1);
    private BigDecimal two = new BigDecimal(2);
    private BigDecimal three = new BigDecimal(3);
    private BigDecimal four = new BigDecimal(4);


    private BigDecimal leftAvg;
    private BigDecimal rightAvg;
    private BigDecimal overallAvg;

    private BigDecimal leftStDev;
    private BigDecimal rightStDev;
    private BigDecimal overallStDev;


    public BricksBean() {
    }

    public void prepareArrayForDataEntry(ActionEvent actionEvent) {
        // Add event code here...

        for (int i = 0; i < nrOfBricksToBeTested.intValue(); i++) {
            listWithData.add(new BoreTestData());
        }
        nrOfRowsToShow=nrOfBricksToBeTested.divide(nrOfColumnsPerRow,0, RoundingMode.DOWN);
        
        
        setVisibleColumns();

    }


    public void setVisibleColumns(){
        if(nrOfBricksToBeTested.compareTo(one)>=0){            
            showCol1=true;
        }
        if(nrOfBricksToBeTested.compareTo(two)>=0){            
            showCol2=true;
        }
        if(nrOfBricksToBeTested.compareTo(three)>=0){            
            showCol3=true;
        }
        if(nrOfBricksToBeTested.compareTo(four)>=0){            
            showCol4=true;
        }

    }
    public void resetArrayWithTestData(ActionEvent actionEvent) {
        // Add event code here..
        System.out.println("ArrayList size before removing elements : " + listWithData.size());
        listWithData.clear();
        showCol1=false;
        showCol2=false;
        showCol3=false;
        showCol4=false;
        System.out.println("ArrayList size after removing elements : " + listWithData.size());

    }


    public void recalcAll(ActionEvent ae) {

        BigDecimal sumLeft = new BigDecimal(0);
        BigDecimal sumRight = new BigDecimal(0);


        for (int i = 0; i < listWithData.size(); i++) {
            sumLeft = sumLeft.add(listWithData.get(i).getLeftData());
            sumRight = sumRight.add(listWithData.get(i).getRightData());
        }
        setLeftAvg(sumLeft.divide(nrOfBricksToBeTested,2, RoundingMode.HALF_UP));
        setRightAvg(sumRight.divide(nrOfBricksToBeTested,2, RoundingMode.HALF_UP));
        setOverallAvg((sumRight.add(sumLeft)).divide(nrOfBricksToBeTested,2, RoundingMode.HALF_UP));


        // here also calculate Standard Deviations.. more of the same, you probably have the code
        
        setLeftStDev(new BigDecimal(0));
        setRightStDev(new BigDecimal(0));
        setOverallStDev(new BigDecimal(0));
        

        
    }


    public void setNrOfBricksToBeTested(BigDecimal nrOfBricksToBeTested) {
        this.nrOfBricksToBeTested = nrOfBricksToBeTested;
    }

    public BigDecimal getNrOfBricksToBeTested() {
        return nrOfBricksToBeTested;
    }

    public void setListWithData(List<BoreTestData> listWithData) {
        this.listWithData = listWithData;
    }

    public List<BoreTestData> getListWithData() {
        return listWithData;
    }

    public void setLeftAvg(BigDecimal leftAvg) {
        this.leftAvg = leftAvg;
    }

    public BigDecimal getLeftAvg() {
        return leftAvg;
    }

    public void setRightAvg(BigDecimal rightAvg) {
        this.rightAvg = rightAvg;
    }

    public BigDecimal getRightAvg() {
        return rightAvg;
    }

    public void setOverallAvg(BigDecimal overallAvg) {
        this.overallAvg = overallAvg;
    }

    public BigDecimal getOverallAvg() {
        return overallAvg;
    }

    public void setLeftStDev(BigDecimal leftStDev) {
        this.leftStDev = leftStDev;
    }

    public BigDecimal getLeftStDev() {
        return leftStDev;
    }

    public void setRightStDev(BigDecimal rightStDev) {
        this.rightStDev = rightStDev;
    }

    public BigDecimal getRightStDev() {
        return rightStDev;
    }

    public void setOverallStDev(BigDecimal overallStDev) {
        this.overallStDev = overallStDev;
    }

    public BigDecimal getOverallStDev() {
        return overallStDev;
    }

    public void setNrOfRowsToShow(BigDecimal nrOfRowsToShow) {
        this.nrOfRowsToShow = nrOfRowsToShow;
    }

    public BigDecimal getNrOfRowsToShow() {
        return nrOfRowsToShow;
    }


    public void setNrOfColumnsPerRow(BigDecimal nrOfColumnsPerRow) {
        this.nrOfColumnsPerRow = nrOfColumnsPerRow;
    }

    public BigDecimal getNrOfColumnsPerRow() {
        return nrOfColumnsPerRow;
    }

    public void setShowCol1(Boolean showCol1) {
        this.showCol1 = showCol1;
    }

    public Boolean getShowCol1() {
        return showCol1;
    }

    public void setShowCol2(Boolean showCol2) {
        this.showCol2 = showCol2;
    }

    public Boolean getShowCol2() {
        return showCol2;
    }

    public void setShowCol3(Boolean showCol3) {
        this.showCol3 = showCol3;
    }

    public Boolean getShowCol3() {
        return showCol3;
    }

    public void setShowCol4(Boolean showCol4) {
        this.showCol4 = showCol4;
    }

    public Boolean getShowCol4() {
        return showCol4;
    }

    public void setOne(BigDecimal one) {
        this.one = one;
    }

    public BigDecimal getOne() {
        return one;
    }

    public void setTwo(BigDecimal two) {
        this.two = two;
    }

    public BigDecimal getTwo() {
        return two;
    }

    public void setThree(BigDecimal three) {
        this.three = three;
    }

    public BigDecimal getThree() {
        return three;
    }

    public void setFour(BigDecimal four) {
        this.four = four;
    }

    public BigDecimal getFour() {
        return four;
    }

}
