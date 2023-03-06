package com.supermarket.market;

public class tax {
    
    private Double federalTax;
    private Double estadualTax;
    private Double MunicipalTax;

    public tax(Double federalTax, Double estadualTax, Double MunicipalTax) {
        this.federalTax = federalTax;
        this.estadualTax = estadualTax;
        this.MunicipalTax = MunicipalTax;
    }

    public Double getFederalTax() {
        return federalTax;
    }

    public void setFederalTax(Double federalTax) {
        this.federalTax = federalTax;
    }

    public Double getEstadualTax() {
        return estadualTax;
    }

    public void setEstadualTax(Double estadualTax) {
        this.estadualTax = estadualTax;
    }

    public Double getMunicipalTax() {
        return MunicipalTax;
    }

    public void setMunicipalTax(Double MunicipalTax) {
        this.MunicipalTax = MunicipalTax;
    }

    @Override
    public String toString() {
        return "tax{" + "federalTax=" + federalTax + ", estadualTax=" + estadualTax + ", MunicipalTax=" + MunicipalTax + '}';
    }
    
}
