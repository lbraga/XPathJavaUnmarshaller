package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299InfoSimples {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]/infoPerApur/ideEstabLot[%d]/infoSimples";

        private String indSimples;
    
            public TaxBrEvent2299InfoSimples(String xml, int pos5, int pos7) {
        String size;
                    String url = String.format(TaxBrEvent2299InfoSimples.BASE_URL, pos5, pos7);
                                    this.indSimples = XPathParser.getValueFromXmlString(xml, url + "/indSimples");
                            }
    }