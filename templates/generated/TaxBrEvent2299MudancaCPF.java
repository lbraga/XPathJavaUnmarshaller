package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299MudancaCPF {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/mudancaCPF";

        private String novoCPF;
    
            public TaxBrEvent2299MudancaCPF(String xml) {
        String size;
                    String url = TaxBrEvent2299MudancaCPF.BASE_URL;
                                    this.novoCPF = XPathParser.getValueFromXmlString(xml, url + "/novoCPF");
                            }
    }