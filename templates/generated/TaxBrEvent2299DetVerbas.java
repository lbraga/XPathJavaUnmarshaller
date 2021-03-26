package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299DetVerbas {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]/infoPerApur/ideEstabLot[%d]/detVerbas[%d]";

        private String codRubr;
    
        private String ideTabRubr;
    
        private String qtdRubr;
    
        private String fatorRubr;
    
        private String vrRubr;
    
        private String indApurIR;
    
            public TaxBrEvent2299DetVerbas(String xml, int pos5, int pos7, int pos8) {
        String size;
                    String url = String.format(TaxBrEvent2299DetVerbas.BASE_URL, pos5, pos7, pos8);
                                    this.codRubr = XPathParser.getValueFromXmlString(xml, url + "/codRubr");
                                            this.ideTabRubr = XPathParser.getValueFromXmlString(xml, url + "/ideTabRubr");
                                            this.qtdRubr = XPathParser.getValueFromXmlString(xml, url + "/qtdRubr");
                                            this.fatorRubr = XPathParser.getValueFromXmlString(xml, url + "/fatorRubr");
                                            this.vrRubr = XPathParser.getValueFromXmlString(xml, url + "/vrRubr");
                                            this.indApurIR = XPathParser.getValueFromXmlString(xml, url + "/indApurIR");
                            }
    }