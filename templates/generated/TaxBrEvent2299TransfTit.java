package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299TransfTit {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/transfTit";

        private String cpfSubstituto;
    
        private String dtNascto;
    
            public TaxBrEvent2299TransfTit(String xml) {
        String size;
                    String url = TaxBrEvent2299TransfTit.BASE_URL;
                                    this.cpfSubstituto = XPathParser.getValueFromXmlString(xml, url + "/cpfSubstituto");
                                            this.dtNascto = XPathParser.getValueFromXmlString(xml, url + "/dtNascto");
                            }
    }