package com.example;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DashboardChart extends VerticalLayout {

    public DashboardChart(List<Datum> data, ChartType type, String title,
                Function<Datum, Number> getConfirmed, Function<Datum, Number> getDeaths, Function<Datum, Number> getRecovered) {
        Chart chart = new Chart(type);
        Configuration configuration = chart.getConfiguration();
        configuration.setTitle(title);
        configuration.getTooltip().setEnabled(true);
        configuration.getxAxis().setType(AxisType.DATETIME);
        configuration.addSeries(getDataSeries(data.stream(), getConfirmed, "Confirmed"));
        configuration.addSeries(getDataSeries(data.stream(), getDeaths, "Deaths"));
        configuration.addSeries(getDataSeries(data.stream(), getRecovered, "Recovered"));

        add(chart);
    }

    private DataSeries getDataSeries(Stream<Datum> data, Function<Datum, Number> function, String name) {
        DataSeries dataSeries = new DataSeries(data
                .map(d -> new DataSeriesItem(
                        LocalDate.parse(d.getDate()).atStartOfDay().toInstant(ZoneOffset.UTC),
                        function.apply(d)
                ))
                .collect(Collectors.toList()));
        dataSeries.setName(name);

        return dataSeries;
    }

}
