/*
 * Copyright (C) 2019 Andreas Redmer <ar-gdroid@abga.be>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.gdroid.gdroid.taskmanagement;

import android.os.AsyncTask;

import org.gdroid.gdroid.GDroidApp;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Stores a pointer to all background task, so they can be canceled if need be.
 */
public class TaskManager {
    Map<DataDescriptor, AsyncTask> taskMap = new HashMap<>();
    static TaskManager instance;
    private GDroidApp app;

    public static void setup(GDroidApp gDroidApp) {
        instance = new TaskManager();
        instance.app = gDroidApp;
    }

    public static void addOrReplaceTask(DataDescriptor dd, AsyncTask t)
    {
        AsyncTask existing = instance.taskMap.get(dd);
        if (existing != null)
        {
            existing.cancel(true);
        }
        instance.taskMap .put(dd,t);
    }

    public static void cancelAll(EnumSet<DataDescriptor> exceptions)
    {
        for (DataDescriptor dd: instance.taskMap.keySet()) {
            if (!exceptions.contains(dd))
            {
                instance.taskMap.get(dd).cancel(true);
            }
        }
    }
}
