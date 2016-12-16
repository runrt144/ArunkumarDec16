package com.flight;
import com.flight.pricing.Tax;
public class Pricing
{
    private String refundable;

    private String saleFareTotal;

    private Fare[] fare;

    private SegmentPricing[] segmentPricing;

    private String fareCalculation;

    private String latestTicketingTime;

    private String ptc;

    private String kind;

    private String baseFareTotal;

    private Passengers passengers;

    private Tax[] tax;

    private String saleTotal;

    private String saleTaxTotal;

    public String getRefundable ()
    {
        return refundable;
    }

    public void setRefundable (String refundable)
    {
        this.refundable = refundable;
    }

    public String getSaleFareTotal ()
    {
        return saleFareTotal;
    }

    public void setSaleFareTotal (String saleFareTotal)
    {
        this.saleFareTotal = saleFareTotal;
    }

    public Fare[] getFare ()
    {
        return fare;
    }

    public void setFare (Fare[] fare)
    {
        this.fare = fare;
    }

    public SegmentPricing[] getSegmentPricing ()
    {
        return segmentPricing;
    }

    public void setSegmentPricing (SegmentPricing[] segmentPricing)
    {
        this.segmentPricing = segmentPricing;
    }

    public String getFareCalculation ()
    {
        return fareCalculation;
    }

    public void setFareCalculation (String fareCalculation)
    {
        this.fareCalculation = fareCalculation;
    }

    public String getLatestTicketingTime ()
    {
        return latestTicketingTime;
    }

    public void setLatestTicketingTime (String latestTicketingTime)
    {
        this.latestTicketingTime = latestTicketingTime;
    }

    public String getPtc ()
    {
        return ptc;
    }

    public void setPtc (String ptc)
    {
        this.ptc = ptc;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public String getBaseFareTotal ()
    {
        return baseFareTotal;
    }

    public void setBaseFareTotal (String baseFareTotal)
    {
        this.baseFareTotal = baseFareTotal;
    }

    public Passengers getPassengers ()
    {
        return passengers;
    }

    public void setPassengers (Passengers passengers)
    {
        this.passengers = passengers;
    }

    public Tax[] getTax ()
    {
        return tax;
    }

    public void setTax (Tax[] tax)
    {
        this.tax = tax;
    }

    public String getSaleTotal ()
    {
        return saleTotal;
    }

    public void setSaleTotal (String saleTotal)
    {
        this.saleTotal = saleTotal;
    }

    public String getSaleTaxTotal ()
    {
        return saleTaxTotal;
    }

    public void setSaleTaxTotal (String saleTaxTotal)
    {
        this.saleTaxTotal = saleTaxTotal;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [refundable = "+refundable+", saleFareTotal = "+saleFareTotal+", fare = "+fare+", segmentPricing = "+segmentPricing+", fareCalculation = "+fareCalculation+", latestTicketingTime = "+latestTicketingTime+", ptc = "+ptc+", kind = "+kind+", baseFareTotal = "+baseFareTotal+", passengers = "+passengers+", tax = "+tax+", saleTotal = "+saleTotal+", saleTaxTotal = "+saleTaxTotal+"]";
    }
}
		