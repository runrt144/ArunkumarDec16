package com.flight;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Passengers
{
    private String adultCount;

    private String kind;

    public String getAdultCount ()
    {
        return adultCount;
    }

    public void setAdultCount (String adultCount)
    {
        this.adultCount = adultCount;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [adultCount = "+adultCount+", kind = "+kind+"]";
    }
}