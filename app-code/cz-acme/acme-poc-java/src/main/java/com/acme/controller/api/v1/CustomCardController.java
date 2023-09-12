package com.acme.controller.api.v1;

import com.acme.common.util.CustomCardConverter;
import com.acme.domain.CustomCard;
import com.acme.domain.CustomCardCallToAction;
import com.acme.domain.CustomCardCallToActionNew;
import com.acme.domain.CustomCardDocument;
import com.acme.domain.CustomCardDocumentNew;
import com.acme.domain.CustomCardLocaleData;
import com.acme.domain.CustomCardMedia;
import com.acme.domain.CustomCardNew;
import com.acme.domain.StringPublishTime;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/custom-cards")
public class CustomCardController {

    @GetMapping("mapinfo")
    public Map<String, CustomCardLocaleData> retrieveMap() {
        var localeDataMap = createCCardLocaleData();

        localeDataMap
            .values()
            .forEach(localeData -> {
                localeData.getMedia().setUri(localeData.getMedia().getUri() + " transformed");
                localeData.getCallToAction().setUri(localeData.getCallToAction().getUri() + " transformed");

            });

        return localeDataMap;
    }

    @GetMapping("showctanew")
    public CustomCardCallToActionNew showCtaNew() {
        var cta = new CustomCardCallToActionNew("link", "http://useen.me");
        System.out.println("CTA -> " + cta);
        return cta;
    }

    @GetMapping("showcta")
    public CustomCardCallToAction showCta() {
        var cta = new CustomCardCallToAction("abc", "link", "http://useen.me");
        System.out.println("CTA -> " + cta);
        return cta;
    }

    @GetMapping("showlocaledata")
    public Map<String, CustomCardLocaleData> retrieveLocaleData() {
        Map<String, CustomCardLocaleData> cCardLocaleData = createCCardLocaleData();
        return cCardLocaleData;
    }

    @GetMapping("customcard")
    public CustomCard retrieveCCard() {
        return createCustomCardInfo();
    }

    @GetMapping("customcardnew")
    public CustomCardNew retrieveCCardNew() {
        return createCustomCardNewInfo();
    }

    @GetMapping("customcarddoc")
    public CustomCardDocument retrieveCCardDoc() {
        return CustomCardConverter.convertToCustomCardDocument(createCustomCardInfo());
    }

    @GetMapping("customcarddocnew")
    public CustomCardDocumentNew retrieveCCardDocNew() {
        return CustomCardConverter.convertToCustomCardDocumentNew(createCustomCardNewInfo());
    }

    private CustomCard createCustomCardInfo() {
        return CustomCard.builder().id("ABccEss")
            .actionType("external")
            .title("The Card Title")
            .description("Card Description")
            .timeZone("America/New_York")
            .sortOrder(0)
            .sites(
                List.of(
                    "destination.wdw",
                    "destination.dlr",
                    "destination.dlp",
                    "destination.parks.and.resorts",
                    "destination.dcl",
                    "destination.cpc",
                    "destination.aulani"))
            .publish(
                StringPublishTime
                    .builder()
                    .start("2023-07-17T13:56:00Z")
                    .end("2023-07-31T13:56:00Z")
                    .build())
            .media(new CustomCardMedia("image", "image.jpg"))
            .callToAction(new CustomCardCallToAction("Cick Me", "link", "http://use.me"))
            .newField("New Field OUT")
            .build();
    }

    private Map<String, CustomCardLocaleData> createCCardLocaleData() {
        return Map.of("en", buildCustomCardLocaleDataEN(),
            "es", buildCustomCardLocaleDataES()
        );
    }

    private CustomCardLocaleData buildCustomCardLocaleDataEN() {
        return CustomCardLocaleData.builder()
            .title("My Info in English")
            .description("In my desc")
            .ctaLabel("Button Label")
            .media(new CustomCardMedia("image", "image.jpg"))
            .callToAction(new CustomCardCallToActionNew("link", "http://useen.me"))
            .build();
    }

    private CustomCardLocaleData buildCustomCardLocaleDataES() {
        return CustomCardLocaleData.builder()
            .title("Mi info en Español")
            .description("En mi desc")
            .ctaLabel("Etiqueta botón")
            .media(new CustomCardMedia("image", "image.jpg"))
            .callToAction(new CustomCardCallToActionNew("link", "http://usees.me"))
            .build();
    }

    private CustomCardNew createCustomCardNewInfo() {
        CustomCardNew build = CustomCardNew.builder().id("ABccEss")
            .actionType("external")
            .timeZone("America/New_York")
            .sortOrder(0)
            .sites(
                List.of(
                    "destination.wdw",
                    "destination.dlr",
                    "destination.dlp",
                    "destination.parks.and.resorts",
                    "destination.dcl",
                    "destination.cpc",
                    "destination.aulani"))
            .publish(
                StringPublishTime
                    .builder()
                    .start("2023-07-17T13:56:00Z")
                    .end("2023-07-31T13:56:00Z")
                    .build())
            .localeData(createCCardLocaleData())
            .build();
        return build;
    }

}
