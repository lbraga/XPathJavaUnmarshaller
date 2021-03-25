package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299RemunOutrEmpr {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/infoMV/remunOutrEmpr[%d]";

        private String tpInsc;
    
        private String nrInsc;
    
        private String codCateg;
    
        private String vlrRemunOE;
    
            public TaxBrEvent2299RemunOutrEmpr(String xml, int pos6) {
        String size;
                    String url = String.format(TaxBrEvent2299RemunOutrEmpr.BASE_URL, pos6);
                                    this.tpInsc = XPathParser.getValueFromXmlString(xml, url + "/tpInsc");
                                            this.nrInsc = XPathParser.getValueFromXmlString(xml, url + "/nrInsc");
                                            this.codCateg = XPathParser.getValueFromXmlString(xml, url + "/codCateg");
                                            this.vlrRemunOE = XPathParser.getValueFromXmlString(xml, url + "/vlrRemunOE");
                            }
    }