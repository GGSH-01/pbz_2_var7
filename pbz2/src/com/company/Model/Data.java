package com.company.Model;

import java.util.Date;

public class Data {
    private String podrazdelenie;
    private String raspisanie;
    private String fio;
    private String vozrast;
    private String pol;
    private String cempol;
    private String doljnost;
    private Date startrab;
    private Date endrab;
    private String olddoljnost;
    private String oldpodrazdelenie;
    private String kolichestvo;
    private String oldrazriad;
    private String razriad;






    public Data (String fio, String vozrast) {
        this.fio = fio;
        this.vozrast = vozrast;
    }

    public Data (String fio, String vozrast, String pol, String cempol,
                 String doljnost, String podrazdelenie, String razriad){
        this.fio = fio;
        this.vozrast = vozrast;
        this.pol = pol;
        this.cempol = cempol;
        this.doljnost = doljnost;
        this.podrazdelenie = podrazdelenie;
        this.razriad = razriad;
    }

    public Data (String fio, Date startrab, Date endrab,
                 String olddoljnost, String oldpodrazdelenie, String oldrazriad) {
        this.fio = fio;
        this.startrab = startrab;
        this.endrab = endrab;
        this.olddoljnost = olddoljnost;
        this.oldpodrazdelenie = oldpodrazdelenie;
        this.oldrazriad = oldrazriad;
    }

    public Data (String podrazdelenie, String raspisanie, String doljnost,
                 String kolichestvo) {
        this.podrazdelenie = podrazdelenie;
        this.raspisanie = raspisanie;
        this.doljnost = doljnost;
        this.kolichestvo = kolichestvo;
    }

    public Data (String fio, String pol, String vozrast) {
        this.fio = fio;
        this.pol = pol;
        this.vozrast = vozrast;
    }



    public void setPodrazdelenie() {
        this.podrazdelenie = podrazdelenie;
    }

    public String getPodrazdelenie() {
        return podrazdelenie;
    }

    public void setRaspisanie() {
        this.raspisanie = raspisanie;
    }

    public String getRaspisanie() {
        return raspisanie;
    }

    public void setFio() { this.fio =fio ; }

    public String getFio() {
        return fio;
    }

    public void setVozrast() {
        this.vozrast = vozrast;
    }

    public String getVozrast() {
        return vozrast;
    }

    public void setPol() {
        this.pol = pol;
    }

    public String getPol() {
        return pol;
    }

    public void setCempol() {
        this.cempol = cempol;
    }

    public String getCempol() {
        return cempol;
    }

    public void setDoljnost() {
        this.doljnost = doljnost;
    }

    public String getDoljnost() {
        return doljnost;
    }

    public void setStartrab() {
        this.startrab = startrab;
    }

    public Date getStartrab() { return startrab; }

    public void setEndrab() {
        this.endrab = endrab;
    }

    public Date getEndrab() {
        return endrab;
    }



    public void setOlddoljnost() {
        this.olddoljnost = olddoljnost;
    }

    public String getOlddoljnost() {
        return olddoljnost;
    }

    public void setOldpodrazdelenie() {
        this.oldpodrazdelenie = oldpodrazdelenie;
    }

    public String getOldpodrazdelenie() {
        return oldpodrazdelenie;
    }

    public void setKolichestvo() {
        this.kolichestvo = kolichestvo;
    }

    public String getKolichestvo() {
        return kolichestvo;
    }

    public String getOldrazriad() {
        return oldrazriad;
    }

    public void setOldrazriad() {
        this.oldrazriad = oldrazriad;
    }


    public String getRazriad() {
        return razriad;
    }

    public void setRazriad() {
        this.razriad = razriad;
    }



}
