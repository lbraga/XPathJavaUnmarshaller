package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299DmDev {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]";

        private String ideDmDev;
    
        private TaxBrEvent2299InfoPerApur infoPerApur;
    
        private TaxBrEvent2299InfoPerAnt infoPerAnt;
    
            public TaxBrEvent2299DmDev(String xml, int pos5) {
        String size;
                    String url = String.format(TaxBrEvent2299DmDev.BASE_URL, pos5);
                                    this.ideDmDev = XPathParser.getValueFromXmlString(xml, url + "/ideDmDev");
                                            this.infoPerApur = new TaxBrEvent2299InfoPerApur(xml, pos5 );
                                            this.infoPerAnt = new TaxBrEvent2299InfoPerAnt(xml, pos5 );
                            }
    }