package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299ProcJudTrab {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/procJudTrab[%d]";

        private String tpTrib;
    
        private String nrProcJud;
    
        private String codSusp;
    
            public TaxBrEvent2299ProcJudTrab(String xml, int pos5) {
        String size;
                    String url = String.format(TaxBrEvent2299ProcJudTrab.BASE_URL, pos5);
                                    this.tpTrib = XPathParser.getValueFromXmlString(xml, url + "/tpTrib");
                                            this.nrProcJud = XPathParser.getValueFromXmlString(xml, url + "/nrProcJud");
                                            this.codSusp = XPathParser.getValueFromXmlString(xml, url + "/codSusp");
                            }
    }