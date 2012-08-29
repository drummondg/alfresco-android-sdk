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
package org.alfresco.mobile.android.samples.ui.documentfolder.actions;

import org.alfresco.mobile.android.api.model.Folder;
import org.alfresco.mobile.android.samples.utils.SessionUtils;
import org.alfresco.mobile.android.ui.documentfolder.actions.CreateFolderDialogFragment;

import android.content.DialogInterface;
import android.os.Bundle;

public class AddFolderDialogFragment extends CreateFolderDialogFragment
{
    
    public AddFolderDialogFragment()
    {
    }
    
    public static AddFolderDialogFragment newInstance(Folder folder){
        AddFolderDialogFragment adf = new AddFolderDialogFragment();
        adf.setArguments(createBundle(folder));
        return adf;
    }
    
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        alfSession = SessionUtils.getsession(getActivity());
        super.onActivityCreated(savedInstanceState);
    }
    
    @Override
    public void onDismiss(DialogInterface dialog)
    {
        super.onDismiss(dialog);
    }
}