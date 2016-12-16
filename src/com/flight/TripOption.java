package com.flight;

public class TripOption
{
    private Pricing[] pricing;

    private String id;

    private String saleTotal;

    private Slice[] slice;

    private String kind;

    public Pricing[] getPricing ()
    {
        return pricing;
    }

    public void setPricing (Pricing[] pricing)
    {
        this.pricing = pricing;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getSaleTotal ()
    {
        return saleTotal;
    }

    public void setSaleTotal (String saleTotal)
    {
        this.saleTotal = saleTotal;
    }

    public Slice[] getSlice ()
    {
        return slice;
    }

    public void setSlice (Slice[] slice)
    {
        this.slice = slice;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    /*public String getTripOption(){
    	"{  \"request\": {   \"slice\": [ { \"origin\": \""+search.getFrom()+"\", \"destination\": \""+search.getTo()+"\",\"date\": \""+search.getDepDate()+"\"}, { \"origin\": \""+search.getTo()+"\", \"destination\": \""+search.getFrom()+"\", \"date\": \""+search.getRetDate()+"\"}], \"passengers\": {\"adultCount\": "+search.getAdult()+",\"infantInLapCount\": "+search.getInfant()+",\"infantInSeatCount\": 0,\"childCount\": "+search.getChild()+",\"seniorCount\": 0}, \"solutions\": 10, \"refundable\": false }}";
    	String tripOpt = "{ \"trip\": {   \"slice\": [ { \"segment\": [
    }*/
    @Override
    public String toString()
    {
        return "ClassPojo [pricing = "+pricing+", id = "+id+", saleTotal = "+saleTotal+", slice = "+slice+", kind = "+kind+"]";
    }
}