package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299EvtDeslig {

    private static final String BASE_URL = "/eSocial/evtDeslig";

        private TaxBrEvent2299IdeEvento ideEvento;
    
        private TaxBrEvent2299IdeEmpregador ideEmpregador;
    
        private TaxBrEvent2299IdeVinculo ideVinculo;
    
        private TaxBrEvent2299InfoDeslig infoDeslig;
    
            public TaxBrEvent2299EvtDeslig(String xml) {
        String size;
                    String url = TaxBrEvent2299EvtDeslig.BASE_URL;
                                            this.ideEvento = new TaxBrEvent2299IdeEvento(xml);
                                                    this.ideEmpregador = new TaxBrEvent2299IdeEmpregador(xml);
                                                    this.ideVinculo = new TaxBrEvent2299IdeVinculo(xml);
                                                    this.infoDeslig = new TaxBrEvent2299InfoDeslig(xml);
                            }
    }