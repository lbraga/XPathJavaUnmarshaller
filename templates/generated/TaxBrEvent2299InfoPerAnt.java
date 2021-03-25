package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299InfoPerAnt {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]/infoPerAnt";

        private List<TaxBrEvent2299IdeADC> ideADCList = new ArrayList<>();
    
            public TaxBrEvent2299InfoPerAnt(String xml, int pos5) {
        String size;
                    String url = String.format(TaxBrEvent2299InfoPerAnt.BASE_URL, pos5);
                                            size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/ideADC)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.ideADCList.add(new TaxBrEvent2299IdeADC(xml, pos5 , i + 1));
                    }
                }
                            }
    }