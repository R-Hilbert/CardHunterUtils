package ui;

import app.App;
import java.util.ArrayList;
import java.util.EnumSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

//class used by ItemTable as context menus to filter items based on Enums
public class EnumFilter<E extends Enum<E>>extends VBox implements IPersistViewState{
    public final ObservableSet<E>set;
    private final Class<E> type;
    
    public EnumFilter(Class<E>type){
        this.type = type;
        final ObservableSet<E>writableSet=FXCollections.observableSet(EnumSet.allOf(type));
        set=FXCollections.unmodifiableObservableSet(writableSet);
        ObservableList<Node>children=getChildren();
        for(final E e:type.getEnumConstants()){
            CheckBox box=new CheckBox(e.toString());
            box.setSelected(true);
            box.setOnAction(event->{
                if(box.isSelected())writableSet.add(e);
                else writableSet.remove(e);
            });
            children.add(box);
        }
    }

    @Override
    public void setViewFromState() {
        String state = App.state().viewState.getControlSetting(type.getName(), "filter");
        if (state != null && !state.isEmpty()) {
            String[] checks = state.split(",");

            ObservableList<Node>children=getChildren();
            for(int ix = 0; ix < checks.length; ix++) {
                CheckBox box=(CheckBox) children.get(ix);

                if (box != null) {
                    box.setSelected(Boolean.parseBoolean(checks[ix]));
                    box.getOnAction().handle(null);
                }
            }
        }
    }

    @Override
    public void updateViewState() {
        ObservableList<Node>children=getChildren();
        ArrayList<String> checks = new ArrayList<>(children.size());
        
        for(Node n : children) {
            CheckBox box=(CheckBox) n;
            
            if (box != null)
                checks.add(box.isSelected() + "");
        }
        
        String checkState = String.join(",", checks);
        App.state().viewState.saveControlSetting(type.getName(), "filter", checkState);
    }

    @Override
    public void refresh() {
        // nothing to do
    }
}