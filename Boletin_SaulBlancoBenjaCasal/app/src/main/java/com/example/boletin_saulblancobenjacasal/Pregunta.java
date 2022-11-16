package com.example.boletin_saulblancobenjacasal;

public class Pregunta {
    int idpregunta;
    String pregunta;
    String resp1;
    String resp2;
    String resp3;
    String resp4;
    String respcorr;

    public Pregunta(int idpregunta, String pregunta, String resp1, String resp2, String resp3, String resp4, String respcorr) {
        this.idpregunta = idpregunta;
        this.pregunta = pregunta;
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
        this.resp4 = resp4;
        this.respcorr = respcorr;
    }

    public int getIdpregunta() {
        return idpregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getResp1() {
        return resp1;
    }

    public String getResp2() {
        return resp2;
    }

    public String getResp3() {
        return resp3;
    }

    public String getResp4() {
        return resp4;
    }

    public String getRespcorr() {
        return respcorr;
    }

    public void setIdpregunta(int idpregunta) {
        this.idpregunta = idpregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setResp1(String resp1) {
        this.resp1 = resp1;
    }

    public void setResp2(String resp2) {
        this.resp2 = resp2;
    }

    public void setResp3(String resp3) {
        this.resp3 = resp3;
    }

    public void setResp4(String resp4) {
        this.resp4 = resp4;
    }

    public void setRespcorr(String respcorr) {
        this.respcorr = respcorr;
    }
}
