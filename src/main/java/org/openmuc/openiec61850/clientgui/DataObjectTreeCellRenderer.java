/*
 * Copyright 2011-17 Fraunhofer ISE, energy & meteo Systems GmbH and other contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.openmuc.openiec61850.clientgui;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.openmuc.openiec61850.BasicDataAttribute;
import org.openmuc.openiec61850.FcModelNode;

public class DataObjectTreeCellRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = 1682378972258556129L;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if (value instanceof DataObjectTreeNode) {
            DataObjectTreeNode treeNode = (DataObjectTreeNode) value;
            if (!leaf && treeNode.getNode() instanceof FcModelNode) {
                setIcon(getLeafIcon());
            }

            if (treeNode.getNode() instanceof BasicDataAttribute) {
                BasicDataAttribute attribute = (BasicDataAttribute) treeNode.getNode();
                String tooltip = attribute.getSAddr();
                setToolTipText(tooltip);
            }
        }

        return this;
    }
}
