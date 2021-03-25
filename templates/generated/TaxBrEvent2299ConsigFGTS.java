package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299ConsigFGTS {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/consigFGTS[%d]";

        private String insConsig;
    
        private String nrContr;
    
            public TaxBrEvent2299ConsigFGTS(String xml, int pos4) {
        String size;
                    String url = String.format(TaxBrEvent2299ConsigFGTS.BASE_URL, pos4);
                                    this.insConsig = XPathParser.getValueFromXmlString(xml, url + "/insConsig");
                                            this.nrContr = XPathParser.getValueFromXmlString(xml, url + "/nrContr");
                            }
    }