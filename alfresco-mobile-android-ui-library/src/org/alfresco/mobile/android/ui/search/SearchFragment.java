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
package org.alfresco.mobile.android.ui.search;

import java.util.ArrayList;

import org.alfresco.mobile.android.api.asynchronous.LoaderResult;
import org.alfresco.mobile.android.api.asynchronous.SearchLoader;
import org.alfresco.mobile.android.api.model.Folder;
import org.alfresco.mobile.android.api.model.KeywordSearchOptions;
import org.alfresco.mobile.android.api.model.ListingContext;
import org.alfresco.mobile.android.api.model.Node;
import org.alfresco.mobile.android.api.model.PagingResult;
import org.alfresco.mobile.android.api.model.SearchLanguage;
import org.alfresco.mobile.android.ui.R;
import org.alfresco.mobile.android.ui.documentfolder.NodeAdapter;
import org.alfresco.mobile.android.ui.fragments.BaseListFragment;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

public abstract class SearchFragment extends BaseListFragment implements
        LoaderCallbacks<LoaderResult<PagingResult<Node>>>
{

    public static final String TAG = "SearchFragment";

    public static final String KEYWORDS = "keywords";

    public static final String INCLUDE_CONTENT = "fulltext";

    public static final String EXACTMATCH = "exact";

    public static final String FOLDER = "folder";

    public static final String INCLUDE_DESCENDANTS = "descendants";

    public static final String STATEMENT = "statement";

    public static final String LANGUAGE = "language";

    private Boolean activateThumbnail = Boolean.TRUE;

    public SearchFragment()
    {
        loaderId = SearchLoader.ID;
        callback = this;
        emptyListMessageId = R.string.empty_search;
        initLoader = false;
    }

    public static Bundle createBundleArgs(String query)
    {
        Bundle args = new Bundle();
        args.putSerializable(KEYWORDS, query);
        return args;
    }

    @Override
    public Loader<LoaderResult<PagingResult<Node>>> onCreateLoader(int id, Bundle b)
    {
        setListShown(false);
        String keywords = null, statement = null, language = null;
        Folder f = null;
        boolean isExact = false, fullText = true, includeDescendants = true;
        ListingContext lc = null, lcorigin = null;

        if (b != null)
        {
            keywords = b.getString(KEYWORDS);
            statement = b.getString(STATEMENT);

            f = (Folder) b.getSerializable(FOLDER);

            language = (b.containsKey(LANGUAGE)) ? b.getString(LANGUAGE) : null;
            isExact = (b.containsKey(EXACTMATCH)) ? b.getBoolean(EXACTMATCH) : isExact;
            fullText = (b.containsKey(INCLUDE_CONTENT)) ? b.getBoolean(INCLUDE_CONTENT) : fullText;
            includeDescendants = (b.containsKey(INCLUDE_DESCENDANTS)) ? b.getBoolean(INCLUDE_DESCENDANTS)
                    : includeDescendants;

            lcorigin = (ListingContext) b.getSerializable(ARGUMENT_LISTING);
            lc = copyListing(lcorigin);
            loadState = b.getInt(LOAD_STATE);
        }

        SearchLoader searchLoader = null;
        if (statement != null)
        {
            searchLoader = new SearchLoader(getActivity(), alfSession, statement, SearchLanguage.fromValue(language));
        }
        else if (keywords != null)
        {
            searchLoader = new SearchLoader(getActivity(), alfSession, keywords, new KeywordSearchOptions(f,
                    includeDescendants, fullText, isExact));
        }
        if (searchLoader != null)
        {
            searchLoader.setListingContext(lc);
        }
        return searchLoader;
    }

    @Override
    public void onLoadFinished(Loader<LoaderResult<PagingResult<Node>>> arg0, LoaderResult<PagingResult<Node>> results)
    {
        if (adapter == null)
        {
            adapter = new NodeAdapter(getActivity(), alfSession, R.layout.sdk_list_row, new ArrayList<Node>(0), null);
        }
        ((NodeAdapter) adapter).setActivateThumbnail(activateThumbnail);

        if (checkException(results))
        {
            onLoaderException(results.getException());
        }
        else
        {
            displayPagingData(results.getData(), loaderId, callback);
        }
    }

    @Override
    public void onLoaderReset(Loader<LoaderResult<PagingResult<Node>>> arg0)
    {
        // TODO Auto-generated method stub
    }

    protected void search(String keywords, boolean fullText, boolean isExact)
    {
        Bundle b = new Bundle();
        b.putString(KEYWORDS, keywords);
        b.putBoolean(INCLUDE_CONTENT, fullText);
        b.putBoolean(EXACTMATCH, isExact);
        reload(b, SearchLoader.ID, this);
    }

    public Boolean hasActivateThumbnail()
    {
        return activateThumbnail;
    }

    public void setActivateThumbnail(Boolean activateThumbnail)
    {
        this.activateThumbnail = activateThumbnail;
    }

}
