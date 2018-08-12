package com.itheima.bos.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 12/08/2018
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Entity
@Table(name = "bc_subarea", schema = "bos32", catalog = "")
public class Subarea {
    private String id;
    private String addresskey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;
    private Decidedzone bcDecidedzoneByDecidedzoneId;
    private Region bcRegionByRegionId;

    @Id
    @Column(name = "id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "addresskey", nullable = true, length = 100)
    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey;
    }

    @Basic
    @Column(name = "startnum", nullable = true, length = 30)
    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum;
    }

    @Basic
    @Column(name = "endnum", nullable = true, length = 30)
    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum;
    }

    @Basic
    @Column(name = "single", nullable = true, length = 1)
    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    @Basic
    @Column(name = "position", nullable = true, length = 255)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subarea subarea = (Subarea) o;

        if (id != null ? !id.equals(subarea.id) : subarea.id != null) return false;
        if (addresskey != null ? !addresskey.equals(subarea.addresskey) : subarea.addresskey != null) return false;
        if (startnum != null ? !startnum.equals(subarea.startnum) : subarea.startnum != null) return false;
        if (endnum != null ? !endnum.equals(subarea.endnum) : subarea.endnum != null) return false;
        if (single != null ? !single.equals(subarea.single) : subarea.single != null) return false;
        if (position != null ? !position.equals(subarea.position) : subarea.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (addresskey != null ? addresskey.hashCode() : 0);
        result = 31 * result + (startnum != null ? startnum.hashCode() : 0);
        result = 31 * result + (endnum != null ? endnum.hashCode() : 0);
        result = 31 * result + (single != null ? single.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "decidedzone_id", referencedColumnName = "id")
    public Decidedzone getBcDecidedzoneByDecidedzoneId() {
        return bcDecidedzoneByDecidedzoneId;
    }

    public void setBcDecidedzoneByDecidedzoneId(Decidedzone bcDecidedzoneByDecidedzoneId) {
        this.bcDecidedzoneByDecidedzoneId = bcDecidedzoneByDecidedzoneId;
    }

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    public Region getBcRegionByRegionId() {
        return bcRegionByRegionId;
    }

    public void setBcRegionByRegionId(Region bcRegionByRegionId) {
        this.bcRegionByRegionId = bcRegionByRegionId;
    }
}