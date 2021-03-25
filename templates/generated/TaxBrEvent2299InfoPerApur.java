package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299InfoPerApur {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]/infoPerApur";

        private List<TaxBrEvent2299IdeEstabLot> ideEstabLotList = new ArrayList<>();
    
            public TaxBrEvent2299InfoPerApur(String xml, int pos5) {
        String size;
                    String url = String.format(TaxBrEvent2299InfoPerApur.BASE_URL, pos5);
                                            size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/ideEstabLot)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.ideEstabLotList.add(new TaxBrEvent2299IdeEstabLot(xml, pos5 , i + 1));
                    }
                }
                            }
    }