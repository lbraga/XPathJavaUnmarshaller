package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299InfoMV {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/infoMV";

        private String indMV;
    
        private List<TaxBrEvent2299RemunOutrEmpr> remunOutrEmprList = new ArrayList<>();
    
            public TaxBrEvent2299InfoMV(String xml) {
        String size;
                    String url = TaxBrEvent2299InfoMV.BASE_URL;
                                    this.indMV = XPathParser.getValueFromXmlString(xml, url + "/indMV");
                                                    size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/remunOutrEmpr)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.remunOutrEmprList.add(new TaxBrEvent2299RemunOutrEmpr(xml, i + 1));
                    }
                }
                            }
    }