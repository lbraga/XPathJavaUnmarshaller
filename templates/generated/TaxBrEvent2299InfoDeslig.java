package com.thomsonreuters.ta.taxbr.efdsocial.dismsl.v_S_01_00_00.layout.gov;

import com.thomsonreuters.ta.taxbr.commons.xml.XPathParser;
import com.thomsonreuters.taxit.commons.util.TaxitObjectUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class TaxBrEvent2299InfoDeslig {

    private static final String BASE_URL = "/eSocial/evtDeslig/infoDeslig";

        private String mtvDeslig;
    
        private String dtDeslig;
    
        private String dtAvPrv;
    
        private String indPagtoAPI;
    
        private String dtProjFimAPI;
    
        private String pensAlim;
    
        private String percAliment;
    
        private String vrAlim;
    
        private String nrProcTrab;
    
        private List<TaxBrEvent2299InfoInterm> infoIntermList = new ArrayList<>();
    
        private List<TaxBrEvent2299Observacoes> observacoesList = new ArrayList<>();
    
        private TaxBrEvent2299SucessaoVinc sucessaoVinc;
    
        private TaxBrEvent2299TransfTit transfTit;
    
        private TaxBrEvent2299MudancaCPF mudancaCPF;
    
        private TaxBrEvent2299VerbasResc verbasResc;
    
        private TaxBrEvent2299Quarentena quarentena;
    
        private List<TaxBrEvent2299ConsigFGTS> consigFGTSList = new ArrayList<>();
    
            public TaxBrEvent2299InfoDeslig(String xml) {
        String size;
                    String url = TaxBrEvent2299InfoDeslig.BASE_URL;
                                    this.mtvDeslig = XPathParser.getValueFromXmlString(xml, url + "/mtvDeslig");
                                            this.dtDeslig = XPathParser.getValueFromXmlString(xml, url + "/dtDeslig");
                                            this.dtAvPrv = XPathParser.getValueFromXmlString(xml, url + "/dtAvPrv");
                                            this.indPagtoAPI = XPathParser.getValueFromXmlString(xml, url + "/indPagtoAPI");
                                            this.dtProjFimAPI = XPathParser.getValueFromXmlString(xml, url + "/dtProjFimAPI");
                                            this.pensAlim = XPathParser.getValueFromXmlString(xml, url + "/pensAlim");
                                            this.percAliment = XPathParser.getValueFromXmlString(xml, url + "/percAliment");
                                            this.vrAlim = XPathParser.getValueFromXmlString(xml, url + "/vrAlim");
                                            this.nrProcTrab = XPathParser.getValueFromXmlString(xml, url + "/nrProcTrab");
                                                    size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/infoInterm)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.infoIntermList.add(new TaxBrEvent2299InfoInterm(xml, i + 1));
                    }
                }
                                                    size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/observacoes)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.observacoesList.add(new TaxBrEvent2299Observacoes(xml, i + 1));
                    }
                }
                                                    this.sucessaoVinc = new TaxBrEvent2299SucessaoVinc(xml);
                                                    this.transfTit = new TaxBrEvent2299TransfTit(xml);
                                                    this.mudancaCPF = new TaxBrEvent2299MudancaCPF(xml);
                                                    this.verbasResc = new TaxBrEvent2299VerbasResc(xml);
                                                    this.quarentena = new TaxBrEvent2299Quarentena(xml);
                                                    size = XPathParser.getValueFromXmlString(xml, "count(" + url + "/consigFGTS)");
                if (!TaxitObjectUtils.isEmpty(size) && Integer.parseInt(size) > 0) {
                    for (int i = 0; i < Integer.parseInt(size); i++) {
                        this.consigFGTSList.add(new TaxBrEvent2299ConsigFGTS(xml, i + 1));
                    }
                }
                            }
    }