package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299ESocial {

    private static final String BASE_URL = "/eSocial";

        private TaxBrEvent2299EvtDeslig evtDeslig;
    
            public TaxBrEvent2299ESocial(String xml) {
        String size;
                    String url = TaxBrEvent2299ESocial.BASE_URL;
                                            this.evtDeslig = new TaxBrEvent2299EvtDeslig(xml);
                            }
    }