package com.acme.common.util;

import com.acme.common.exception.BadRequestException;
import com.acme.domain.CustomCard;
import com.acme.domain.CustomCardDocument;
import com.acme.domain.CustomCardDocumentNew;
import com.acme.domain.CustomCardMedia;
import com.acme.domain.CustomCardNew;
import com.acme.domain.StringPublishTime;
import com.acme.domain.TimestampPublishTime;
import com.google.cloud.Timestamp;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class CustomCardConverter {

    private CustomCardConverter() {
    }

    public static CustomCard convertToCustomCard(String id, CustomCardDocument customCardDocument) {
        if (Objects.isNull(customCardDocument)) {
            return null;
        }

        return CustomCard.builder()
            .id(id)
            .actionType(customCardDocument.getActionType())
            .title(customCardDocument.getTitle())
            .description(customCardDocument.getDescription())
            .timeZone(customCardDocument.getTimeZone())
            .sortOrder(customCardDocument.getSortOrder())
            .sites(customCardDocument.getSites())
            .publish(getStringPublishTime(customCardDocument.getPublish()))
            .media(extractCastLifeDomainFromImageName(customCardDocument.getMedia()))
            .callToAction(customCardDocument.getCallToAction())
            .updated(getStringFromTimestamp(customCardDocument.getUpdated()))
            .build();
    }

    public static CustomCardDocument convertToCustomCardDocument(CustomCard customCard) {
        return CustomCardDocument.builder()
            .actionType(customCard.getActionType())
            .title(customCard.getTitle())
            .description(customCard.getDescription())
            .timeZone(customCard.getTimeZone())
            .sortOrder(customCard.getSortOrder())
            .sites(customCard.getSites())
            .publish(getTimestampPublishTime(customCard.getPublish()))
            .media(addCastLifeDomainToImageName(customCard.getMedia()))
            .callToAction(customCard.getCallToAction())
            .updated(Timestamp.now())
            .newField(customCard.getNewField())
            .build();
    }

    public static CustomCardDocumentNew convertToCustomCardDocumentNew(CustomCardNew customCard) {
        return CustomCardDocumentNew.builder()
            .id(customCard.getId())
            .actionType(customCard.getActionType())
            .timeZone(customCard.getTimeZone())
            .sortOrder(customCard.getSortOrder())
            .sites(customCard.getSites())
            .publish(getTimestampPublishTime(customCard.getPublish()))
            .localeData(customCard.getLocaleData())
            .updated(Timestamp.now())
            .build();
    }

    private static StringPublishTime getStringPublishTime(TimestampPublishTime publishTime) {
        if (Objects.isNull(publishTime)) {
            return null;
        }

        StringPublishTime publish = new StringPublishTime();

        if (Objects.nonNull(publishTime.getEnd())) {
            String endTime = publishTime.getEnd().toString();
            publish.setEnd(endTime);
        }

        if (Objects.nonNull(publishTime.getStart())) {
            String startTime = publishTime.getStart().toString();
            publish.setStart(startTime);
        }

        return publish;
    }

    private static TimestampPublishTime getTimestampPublishTime(StringPublishTime publishTime) {
        if (Objects.isNull(publishTime)) {
            return null;
        }

        Timestamp startTime = null;
        Timestamp endTime = null;

        if (StringUtils.isNotBlank(publishTime.getStart())) {
            startTime = Timestamp.parseTimestamp(publishTime.getStart());
        }

        if (StringUtils.isNotBlank(publishTime.getEnd())) {
            endTime = Timestamp.parseTimestamp(publishTime.getEnd());
        }

        if (Objects.nonNull(endTime) && Objects.nonNull(startTime)) {
            if (startTime.compareTo(endTime) > 0) {
                throw new BadRequestException("The start time must be before end time");
            }
        }

        return TimestampPublishTime.builder().start(startTime).end(endTime).build();
    }

    /**
     * Put in the Cast Life domain and API name into the Cloud Storage Image name ex:
     * 1de827fe1fd47cdb63db142a638bcd003a991d6fd2bc3615405107f2cb12b222.png will become
     * http://localhost:8087/api/v1/images/castlife/1de827fe1fd47cdb63db142a638bcd003a991d6fd2bc3615405107f2cb12b222.png
     *
     * <p>Needed to support Cast Life custom cards when getting the image through Hub Services
     *
     * @param cardMedia type and the uri of the image
     * @return link to the image for Cast Life in Firestore
     */
    private static CustomCardMedia addCastLifeDomainToImageName(CustomCardMedia cardMedia) {


        return cardMedia;
    }

    /**
     * Opposite of the `addCastLifeDomainToImageName` method
     *
     * @param cardMedia type and the uri of the image
     * @return extracted image name
     */
    private static CustomCardMedia extractCastLifeDomainFromImageName(CustomCardMedia cardMedia) {


        return cardMedia;
    }

    private static String getStringFromTimestamp(Timestamp timestamp) {
        if (Objects.isNull(timestamp)) {
            return null;
        }

        return timestamp.toString();
    }
}
