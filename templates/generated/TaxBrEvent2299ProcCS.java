package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299ProcCS {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/procCS";

        private String nrProcJud;
    
            public TaxBrEvent2299ProcCS(String xml) {
        String size;
                    String url = TaxBrEvent2299ProcCS.BASE_URL;
                                    this.nrProcJud = XPathParser.getValueFromXmlString(xml, url + "/nrProcJud");
                            }
    }