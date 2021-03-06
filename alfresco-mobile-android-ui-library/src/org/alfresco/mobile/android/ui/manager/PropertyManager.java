/*******************************************************************************
 * Copyright (C) 2005-2012 Alfresco Software Limited.
 * 
 * This file is part of the Alfresco Mobile SDK.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************/
package org.alfresco.mobile.android.ui.manager;

import java.util.HashMap;
import java.util.Map;

import org.alfresco.mobile.android.api.constants.ContentModel;
import org.alfresco.mobile.android.ui.R;

public class PropertyManager
{

    @SuppressWarnings("serial")
    private static final Map<String, Integer> ASPECT_GENERAL = new HashMap<String, Integer>(2)
    {
        {
            put(ContentModel.PROP_CREATOR, R.string.metadata_prop_creator);
            put(ContentModel.PROP_CREATED, R.string.metadata_prop_creationdate);
            put(ContentModel.PROP_MODIFIED, R.string.metadata_prop_modificationdate);
            put(ContentModel.PROP_MODIFIER, R.string.metadata_prop_modifier);
            put(ContentModel.PROP_NAME, R.string.metadata_prop_name);
            put(ContentModel.PROP_VERSION_LABEL, R.string.metadata_prop_version);
        }
    };
    
    
    @SuppressWarnings("serial")
    private static final Map<String, Integer> ASPECT_GEOGRAPHIC = new HashMap<String, Integer>(2)
    {
        {
            put(ContentModel.PROP_LATITUDE, R.string.metadata_prop_latitude);
            put(ContentModel.PROP_LONGITUDE, R.string.metadata_prop_longitude);
        }
    };

    @SuppressWarnings("serial")
    private static final Map<String, Integer> ASPECT_AUDIO = new HashMap<String, Integer>(9)
    {
        {
            put(ContentModel.PROP_ALBUM, R.string.metadata_prop_album);
            put(ContentModel.PROP_ARTIST, R.string.metadata_prop_artist);
            put(ContentModel.PROP_COMPOSER, R.string.metadata_prop_composer);
            put(ContentModel.PROP_ENGINEER, R.string.metadata_prop_engineer);
            put(ContentModel.PROP_GENRE, R.string.metadata_prop_genre);
            put(ContentModel.PROP_TRACK_NUMBER, R.string.metadata_prop_track_number);
            put(ContentModel.PROP_RELEASE_DATE, R.string.metadata_prop_release_date);
            put(ContentModel.PROP_SAMPLE_RATE, R.string.metadata_prop_sample_rate);
            put(ContentModel.PROP_SAMPLE_TYPE, R.string.metadata_prop_sample_type);
            put(ContentModel.PROP_CHANNEL_TYPE, R.string.metadata_prop_channel_type);
            put(ContentModel.PROP_COMPRESSOR, R.string.metadata_prop_compressor);

        }
    };

    @SuppressWarnings("serial")
    private static final Map<String, Integer> ASPECT_EXIF = new HashMap<String, Integer>(15)
    {
        {
            put(ContentModel.PROP_DATETIME_ORIGINAL, R.string.metadata_prop_datetime_original);
            put(ContentModel.PROP_PIXELX_DIMENSION, R.string.metadata_prop_pixelx_dimension);
            put(ContentModel.PROP_PIXELY_DIMENSION, R.string.metadata_prop_pixely_dimension);
            put(ContentModel.PROP_EXPOSURE_TIME, R.string.metadata_prop_exposure_time);
            put(ContentModel.PROP_FNUMBER, R.string.metadata_prop_fnumber);
            put(ContentModel.PROP_FLASH_ACTIVATED, R.string.metadata_prop_flash_activated);
            put(ContentModel.PROP_FOCAL_LENGTH, R.string.metadata_prop_focal_length);
            put(ContentModel.PROP_ISO_SPEED, R.string.metadata_prop_iso_speed);
            put(ContentModel.PROP_MANUFACTURER, R.string.metadata_prop_manufacturer);
            put(ContentModel.PROP_MODEL, R.string.metadata_prop_model);
            put(ContentModel.PROP_SOFTWARE, R.string.metadata_prop_software);
            put(ContentModel.PROP_ORIENTATION, R.string.metadata_prop_orientation);
            put(ContentModel.PROP_XRESOLUTION, R.string.metadata_prop_xresolution);
            put(ContentModel.PROP_YRESOLUTION, R.string.metadata_prop_yresolution);
            put(ContentModel.PROP_RESOLUTION_UNIT, R.string.metadata_prop_resolution_unit);
        }
    };

    @SuppressWarnings("serial")
    private static final Map<String, Map<String, Integer>> ASPECT_PROPS_LIST = new HashMap<String, Map<String, Integer>>(
            3)
    {
        {
            put(ContentModel.ASPECT_GENERAL, ASPECT_GENERAL);
            put(ContentModel.ASPECT_GEOGRAPHIC, ASPECT_GEOGRAPHIC);
            put(ContentModel.ASPECT_AUDIO, ASPECT_AUDIO);
            put(ContentModel.ASPECT_EXIF, ASPECT_EXIF);

        }
    };
    
    @SuppressWarnings("serial")
    private static final Map<String, Integer> ASPECTS = new HashMap<String, Integer>(3)
    {
        {
            put(ContentModel.ASPECT_GENERAL, R.string.metadata);
            put(ContentModel.ASPECT_GEOGRAPHIC, R.string.metadata_aspect_geographic);
            put(ContentModel.ASPECT_AUDIO, R.string.metadata_aspect_audio);
            put(ContentModel.ASPECT_EXIF, R.string.metadata_aspect_exif);
        }
    };

    public static Map<String, Integer> getPropertyLabel(String aspect)
    {
        return ASPECT_PROPS_LIST.get(aspect);
    }
    
    public static Integer getAspectLabel(String aspect){
        return ASPECTS.get(aspect);
    }

}
