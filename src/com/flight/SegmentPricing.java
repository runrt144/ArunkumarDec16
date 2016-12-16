package com.flight;

public class SegmentPricing
{
    private String fareId;

    private String segmentId;

    private String kind;

    public String getFareId ()
    {
        return fareId;
    }

    public void setFareId (String fareId)
    {
        this.fareId = fareId;
    }

    public String getSegmentId ()
    {
        return segmentId;
    }

    public void setSegmentId (String segmentId)
    {
        this.segmentId = segmentId;
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
        return "ClassPojo [fareId = "+fareId+", segmentId = "+segmentId+", kind = "+kind+"]";
    }
}
	