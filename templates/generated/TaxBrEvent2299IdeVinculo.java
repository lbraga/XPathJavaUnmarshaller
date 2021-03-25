package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299IdeVinculo {

    private static final String BASE_URL = "/eSocial/evtDeslig/ideVinculo";

        private String cpfTrab;
    
        private String matricula;
    
            public TaxBrEvent2299IdeVinculo(String xml) {
        String size;
                    String url = TaxBrEvent2299IdeVinculo.BASE_URL;
                                    this.cpfTrab = XPathParser.getValueFromXmlString(xml, url + "/cpfTrab");
                                            this.matricula = XPathParser.getValueFromXmlString(xml, url + "/matricula");
                            }
    }