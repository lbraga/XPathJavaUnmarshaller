package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299IdeEvento {

    private static final String BASE_URL = "/eSocial/evtDeslig/ideEvento";

        private String indRetif;
    
        private String indGuia;
    
        private String tpAmb;
    
        private String procEmi;
    
        private String verProc;
    
            public TaxBrEvent2299IdeEvento(String xml) {
        String size;
                    String url = TaxBrEvent2299IdeEvento.BASE_URL;
                                    this.indRetif = XPathParser.getValueFromXmlString(xml, url + "/indRetif");
                                            this.indGuia = XPathParser.getValueFromXmlString(xml, url + "/indGuia");
                                            this.tpAmb = XPathParser.getValueFromXmlString(xml, url + "/tpAmb");
                                            this.procEmi = XPathParser.getValueFromXmlString(xml, url + "/procEmi");
                                            this.verProc = XPathParser.getValueFromXmlString(xml, url + "/verProc");
                            }
    }