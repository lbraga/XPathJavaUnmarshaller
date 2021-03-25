package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299IdeADC {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]/infoPerAnt/ideADC[%d]";

        private String dtAcConv;
    
        private String tpAcConv;
    
        private String dsc;
    
        private List<TaxBrEvent2299IdePeriodo> idePeriodoList = new ArrayList<>();
    
            public TaxBrEvent2299IdeADC(String xml, int pos5, int pos7) {
        String size;
                    String url = String.format(TaxBrEvent2299IdeADC.BASE_URL, pos5, pos7);
                                    this.dtAcConv = XPathParser.getValueFromXmlString(xml, url + "/dtAcConv");
                                            this.tpAcConv = XPathParser.getValueFromXmlString(xml, url + "/tpAcConv");
                                            this.dsc = XPathParser.getValueFromXmlString(xml, url + "/dsc");
                                            size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/idePeriodo)");
        if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
            for (int i = 0; i < Integer.parseInt(size); i++) {
                this.idePeriodoList.add(new TaxBrEvent2299IdePeriodo(xml, pos5 , pos7 , i + 1));
            }
        }
                            }
    }