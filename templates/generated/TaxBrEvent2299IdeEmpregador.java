package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299IdeEmpregador {

    private static final String BASE_URL = "/eSocial/evtDeslig/ideEmpregador";

        private String tpInsc;
    
        private String nrInsc;
    
            public TaxBrEvent2299IdeEmpregador(String xml) {
        String size;
                    String url = TaxBrEvent2299IdeEmpregador.BASE_URL;
                                    this.tpInsc = XPathParser.getValueFromXmlString(xml, url + "/tpInsc");
                                            this.nrInsc = XPathParser.getValueFromXmlString(xml, url + "/nrInsc");
                            }
    }