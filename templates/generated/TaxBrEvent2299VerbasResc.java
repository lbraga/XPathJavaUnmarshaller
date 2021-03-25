package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299VerbasResc {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc";

        private List<TaxBrEvent2299DmDev> dmDevList = new ArrayList<>();
    
        private List<TaxBrEvent2299ProcJudTrab> procJudTrabList = new ArrayList<>();
    
        private TaxBrEvent2299InfoMV infoMV;
    
        private TaxBrEvent2299ProcCS procCS;
    
            public TaxBrEvent2299VerbasResc(String xml) {
        String size;
                    String url = TaxBrEvent2299VerbasResc.BASE_URL;
                                            size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/dmDev)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.dmDevList.add(new TaxBrEvent2299DmDev(xml, i + 1));
                    }
                }
                                                    size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/procJudTrab)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.procJudTrabList.add(new TaxBrEvent2299ProcJudTrab(xml, i + 1));
                    }
                }
                                                    this.infoMV = new TaxBrEvent2299InfoMV(xml);
                                                    this.procCS = new TaxBrEvent2299ProcCS(xml);
                            }
    }