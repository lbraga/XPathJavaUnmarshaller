package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299IdeEstabLot {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig/verbasResc/dmDev[%d]/infoPerApur/ideEstabLot[%d]";

        private String tpInsc;
    
        private String nrInsc;
    
        private String codLotacao;
    
        private List<TaxBrEvent2299DetVerbas> detVerbasList = new ArrayList<>();
    
        private TaxBrEvent2299InfoAgNocivo infoAgNocivo;
    
        private TaxBrEvent2299InfoSimples infoSimples;
    
            public TaxBrEvent2299IdeEstabLot(String xml, int pos5, int pos7) {
        String size;
                    String url = String.format(TaxBrEvent2299IdeEstabLot.BASE_URL, pos5, pos7);
                                    this.tpInsc = XPathParser.getValueFromXmlString(xml, url + "/tpInsc");
                                            this.nrInsc = XPathParser.getValueFromXmlString(xml, url + "/nrInsc");
                                            this.codLotacao = XPathParser.getValueFromXmlString(xml, url + "/codLotacao");
                                            size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/detVerbas)");
        if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
            for (int i = 0; i < Integer.parseInt(size); i++) {
                this.detVerbasList.add(new TaxBrEvent2299DetVerbas(xml, pos5 , pos7 , i + 1));
            }
        }
                                            this.infoAgNocivo = new TaxBrEvent2299InfoAgNocivo(xml, pos5 , pos7 );
                                            this.infoSimples = new TaxBrEvent2299InfoSimples(xml, pos5 , pos7 );
                            }
    }